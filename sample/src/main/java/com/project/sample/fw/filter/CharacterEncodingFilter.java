package com.project.sample.fw.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * org.springframework.web.filter.CharacterEncodingFilter
 *
 * <br/>
 * @author shop_2
 * @date 2017. 4. 27.
 */
public class CharacterEncodingFilter extends OncePerRequestFilter{

    private String encoding;

    private boolean forceRequestEncoding = false;

    private boolean forceResponseEncoding = false;

    public CharacterEncodingFilter() {
	// TODO Auto-generated constructor stub
    }

    public CharacterEncodingFilter(String encoding) {
	this(encoding, false);
    }

    public CharacterEncodingFilter(String encoding, boolean forceEncoding) {
	this(encoding, forceEncoding, forceEncoding);
    }

    public CharacterEncodingFilter(String encoding, boolean forceRequestEncoding, boolean forceResponseEncoding) {
	Assert.hasLength(encoding, "Encoding must not be empty");
	this.encoding = encoding;
	this.forceRequestEncoding = forceRequestEncoding;
	this.forceResponseEncoding = forceResponseEncoding;
    }

    public void setEncoding(String encoding) {
	this.encoding = encoding;
    }

    public String getEncoding() {
	return this.encoding;
    }

    public void setForceEncoding(boolean forceEncoding) {
	this.forceRequestEncoding = forceEncoding;
	this.forceResponseEncoding = forceEncoding;
    }

    public void setForceRequestEncoding(boolean forceRequestEncoding) {
	this.forceRequestEncoding = forceRequestEncoding;
    }

    public boolean isForceRequestEncoding() {
	return this.forceRequestEncoding;
    }

    public void setForceResponseEncoding(boolean forceResponseEncoding) {
	this.forceResponseEncoding = forceResponseEncoding;
    }

    public boolean isForceResponseEncoding() {
	return this.forceResponseEncoding;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
	    HttpServletResponse response, FilterChain filterChain)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	String encoding = getEncoding();
	if (encoding != null) {
		if (isForceRequestEncoding() || request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encoding);
		}
		if (isForceResponseEncoding()) {
//			response.setCharacterEncoding(encoding);
		}
	}
	filterChain.doFilter(request, response);
    }

}
