/**
 * 
 */
package com.loan.core.entity.resp;

/**
 * @author Angel
 *
 */
public class LoginResp {
   
	private String username;
	private String status;
	private String token;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
