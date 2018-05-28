package com.xiangxiaole.www.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * created by xiaxun on 2017/9/13
 **/
@Component
public class LdapManager {

    private  DirContext ctx;
    @Value("${ldap.host.url}")
    private  String host;
    @Value("${ldap.root}")
    private  String root;
    @Value("${ldap.account}")
    private  String account;
    @Value("${ldap.password}")
    private  String password;

    /**
     * 验证账号
     *
     * @param user
     * @param pwd
     * @return
     */
    public boolean authenticate(String user, String pwd) {

        return getCtx(user, pwd) != null;
    }

    /**
     * 从LDAP中查询用户信息
     *
     * @param user
     */
    public Map<String, Object> queryUserInfo(String user) {

        DirContext context = getCtx(account, password);
        if (context == null) {
            return null;
        }
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
        try {
            NamingEnumeration en = ctx.search("", "uid=" + user, constraints);
            if (en != null && en.hasMoreElements()) {
                Object obj = en.nextElement();
                if (obj instanceof SearchResult) {
                    SearchResult si = (SearchResult) obj;
                    System.out.println("name:   " + si.getName());
                    Attributes attrs = si.getAttributes();
                    if (attrs == null) {
                        return null;
                    }
                    Map<String, Object> resMap = attrs2Map(attrs);
                    return resMap;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    private Map<String, Object> attrs2Map(Attributes attrs) {

        Map<String, Object> map = new HashMap<String, Object>();
        NamingEnumeration en = attrs.getAll();
        try {
            while (en != null && en.hasMoreElements()) {
                Attribute attr = (Attribute) en.nextElement();
                map.put(attr.getID(), attr.get());
            }
        } catch (Exception e) {

        }

        return map;
    }


    private DirContext getCtx(String user, String pwd) {

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, host);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=" + user + "," + root);
        env.put(Context.SECURITY_CREDENTIALS, pwd);
        try {
            // 链接ldap
            ctx = new InitialDirContext(env);
            return ctx;
        } catch (javax.naming.AuthenticationException e) {
        	e.printStackTrace();
            System.out.println("认证失败:" + user);
        } catch (Exception e) {
        	System.out.println("认证出错:" + user);
        }
        return null;
    }

    public static void main(String[] args) {
    	String[] s1= "".split(";");
    	
        LdapManager ldap = new LdapManager();
        ldap.host = "ldap://ldap.citicsinfo.com:389/";
        ldap.root = "cn=users,DC=CITICS,DC=COM";
        ldap.account="tgqdcloud";
        ldap.password = "Citicso.com";

      //  System.out.println(ldap.authenticate("root", "Admin84588763"));
        System.out.println(ldap.authenticate("015967", "haha1ovenini"));
        Map<String, Object> map = ldap.queryUserInfo("gongli");
        for(String s : map.keySet()){
            System.out.println(s + ":" + map.get(s));
        }
   }

}
