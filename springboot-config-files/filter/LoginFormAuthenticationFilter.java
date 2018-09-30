package com.cms.kernel.filter;

import com.cms.front.service.UserService;
import com.cms.kernel.entity.User;
import com.cms.kernel.realm.MyUserPasswordToken;
import com.cms.kernel.util.RequestUtil;
import com.cms.kernel.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFormAuthenticationFilter extends FormAuthenticationFilter
{
    private Logger logger=LogManager.getLogger(LoginFormAuthenticationFilter.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @Override
    public void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

  //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
    {

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception
    {

    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception
    {

    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception
    {
        ResponseUtil.renderJSON((HttpServletResponse)response,"{\"result\":1}");
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response)
    {
        ResponseUtil.renderJSON((HttpServletResponse)response,"{\"result\":0}");
        return false;
    }
}
