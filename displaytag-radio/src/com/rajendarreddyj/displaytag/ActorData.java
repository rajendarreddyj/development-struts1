/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajendarreddyj.displaytag;

import java.util.ArrayList;

/**
 *
 * @author rajendarreddy jagapathi
 */
public class ActorData {

	private String id;
	private String option;
	private String tvShow;
	private String userName;
	private String emailId;

	public ActorData() {

	}

	public ActorData(String id, String tvShow, String userName, String emailId, String option) {
		this.id = id;
		this.tvShow = tvShow;
		this.userName = userName;
		this.emailId = emailId;
		this.option = option;
	}

	public ArrayList<ActorData> loadData() {
		ArrayList<ActorData> userList = new ArrayList<>();
		userList.add(new ActorData("1", "User1", "Michael Scott", "michael.scott@dundermifflin.com", "optIn"));
		userList.add(new ActorData("2", "User2", "Dwight Schrute", "dwight.schrute@dundermifflin.com", "optIn"));
		userList.add(new ActorData("3", "User3", "Jim Halpert", "jim.halpert@dundermifflin.com", "optIn"));
		userList.add(new ActorData("4", "User4", "Pam Beesly", "pam.beesly@dundermifflin.com", "optIn"));
		userList.add(new ActorData("5", "User5", "Andy Bernad", "andy.bernad@dundermifflin.com", "optIn"));
		userList.add(new ActorData("6", "User6", "Angela Martin", "angela.martin@dundermifflin.com", "optIn"));
		userList.add(new ActorData("7", "User7", "Rachel Green", "rachel.green@friends.com", "optIn"));
		userList.add(new ActorData("8", "User8", "Monica Geller", "monica.geller@friends.com", "optIn"));
		userList.add(new ActorData("9", "User9", "Phoebe Buffay", "phoebe.buffay@friends.com", "optIn"));
		userList.add(new ActorData("10", "User10", "Joey Tribbiani", "joey.tribbiani@friends.com", "optIn"));
		userList.add(new ActorData("11", "User11", "Chandler Bing", "chandler.bing@friends.com", "optIn"));
		userList.add(new ActorData("12", "User12", "Ross Geller", "ross.geller@friends.com", "optIn"));
		return userList;
	}

	/**
	 * @return the tvShow
	 */
	public String getTvShow() {
		return tvShow;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ActorData [id=" + id + ", option=" + option + ", tvShow=" + tvShow + ", userName=" + userName
				+ ", emailId=" + emailId + "]";
	}

}
