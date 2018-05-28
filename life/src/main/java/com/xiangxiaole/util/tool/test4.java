package com.xiangxiaole.util.tool;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test4 {

    public static void main(String[] args) throws Exception {
    	String path = "F:\\atch.xls";
       File file = new File(path);
       String[][] result = getData(file, 0);
       int rowLength = result.length;
       System.out.println(rowLength);
       for(int i=0;i<rowLength;i++) {
        	  getInternetRes("F:\\download2\\"+result[i][1]+"_"+result[i][2],result[i][4],result[i][0]+"_"+result[i][3]);
        	  System.out.println(i);
       }

    }
	private static void getInternetRes(String savepath, String resurl, String fileName) {
        URL url = null;
        HttpURLConnection con = null;
        InputStream in = null;
        FileOutputStream out = null;
        try {
            url = new URL(resurl);
            //建立http连接，得到连接对象
            con = (HttpURLConnection) url.openConnection();
            in = con.getInputStream();
            byte[] data = getByteData(in);//转化为byte数组

            File file = new File(savepath);
            if (!file.exists()) {
                file.mkdirs();
            }

            File res = new File(file + File.separator + fileName);
            out = new FileOutputStream(res);
            out.write(data);
           // System.out.println("downloaded successfully!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out)
                    out.close();
                if (null != in)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
	/**
     * 从输入流中获取字节数组
     * 
     * @param in
     * @return
     * @throws IOException
     */
    private static byte[] getByteData(InputStream in) throws IOException {
        byte[] b = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        while ((len = in.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        if(null!=bos){
            bos.close();
        }
        return bos.toByteArray();
    }
	
	
	
	
	
	
	
	
	
	
	
	/**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(File file, int ignoreRows)
           throws FileNotFoundException, IOException {
       List<String[]> result = new ArrayList<String[]>();
       int rowSize = 0;
       BufferedInputStream in = new BufferedInputStream(new FileInputStream(
              file));
       // 打开HSSFWorkbook
      // POIFSFileSystem fs = new POIFSFileSystem(in);
       Workbook wb = new HSSFWorkbook(in);
       Cell cell = null;
       for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
           Sheet st = wb.getSheetAt(sheetIndex);
           // 第一行为标题，不取
           for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
              Row row = st.getRow(rowIndex);
              if (row == null) {
                  continue;
              }
              int tempRowSize = row.getLastCellNum() + 1;
              if (tempRowSize > rowSize) {
                  rowSize = tempRowSize;
              }
              String[] values = new String[rowSize];
              Arrays.fill(values, "");
              boolean hasValue = false;
              for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                  String value = "";
                  cell = row.getCell(columnIndex);
                  if (cell != null) {
                     // 注意：一定要设成这个，否则可能会出现乱码
                    // cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                     switch (cell.getCellType()) {
                     case Cell.CELL_TYPE_STRING:
                         value = cell.getStringCellValue();
                         break;
                     case Cell.CELL_TYPE_NUMERIC:
                         if (DateUtil.isCellDateFormatted(cell)) {
                            Date date = cell.getDateCellValue();
                            if (date != null) {
                                value = new SimpleDateFormat("yyyy-MM-dd")
                                       .format(date);
                            } else {
                                value = "";
                            }
                         } else {
                            value = new DecimalFormat("0").format(cell
                                   .getNumericCellValue());
                         }
                         break;
                     case Cell.CELL_TYPE_FORMULA:
                         // 导入时如果为公式生成的数据则无值
                         if (!cell.getStringCellValue().equals("")) {
                            value = cell.getStringCellValue();
                         } else {
                            value = cell.getNumericCellValue() + "";
                         }
                         break;
                     case Cell.CELL_TYPE_BLANK:
                         break;
                     case Cell.CELL_TYPE_ERROR:
                         value = "";
                         break;
                     case Cell.CELL_TYPE_BOOLEAN:
                         value = (cell.getBooleanCellValue() == true ? "Y"
                                : "N");
                         break;
                     default:
                         value = "";
                     }
                  }
                  if (columnIndex == 0 && value.trim().equals("")) {
                     break;
                  }
                  values[columnIndex] = rightTrim(value);
                  hasValue = true;
              }

              if (hasValue) {
                  result.add(values);
              }
           }
       }
       in.close();
       String[][] returnArray = new String[result.size()][rowSize];
       for (int i = 0; i < returnArray.length; i++) {
           returnArray[i] = (String[]) result.get(i);
       }
       return returnArray;
    }

    /**
     * 去掉字符串右边的空格
     * @param str 要处理的字符串
     * @return 处理后的字符串
     */
     public static String rightTrim(String str) {
       if (str == null) {
           return "";
       }
       int length = str.length();
       for (int i = length - 1; i >= 0; i--) {
           if (str.charAt(i) != 0x20) {
              break;
           }
           length--;
       }
       return str.substring(0, length);
    }
}
