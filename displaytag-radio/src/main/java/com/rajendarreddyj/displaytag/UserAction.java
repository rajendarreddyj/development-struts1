/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rajendarreddyj.displaytag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author rajendarreddy jagapathi
 */
public class UserAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	private final static String SUCCESS = "success";

	/**
	 * This is the action called from the Struts framework.
	 * 
	 * @param mapping  The ActionMapping used to select this instance.
	 * @param form     The optional ActionForm bean for this request.
	 * @param request  The HTTP Request we are processing.
	 * @param response The HTTP Response we are processing.
	 * @throws java.lang.Exception
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		ActorData actorData = new ActorData();

		Map<String, ActorData> modifiedListMap = new HashMap<String, ActorData>();
		if (request.getSession().getAttribute("modifiedListmap") != null) {
			modifiedListMap = (Map<String, ActorData>) request.getSession().getAttribute("modifiedListmap");
		} else {
			for (Object actor : actorData.loadData()) {
				modifiedListMap.put(((ActorData) actor).getId() + "_chk", (ActorData) actor);
			}
			userForm.setActorList(getSortedListFromMap(modifiedListMap));
			request.getSession().setAttribute("modifiedListmap", modifiedListMap);
		}
		// this will set values in session
		this.setValuesInModifiedList(request, modifiedListMap);

		if (null != request.getParameter("pagetagtype")) {
			System.out.println("pagetagtype");
		} else {
			// Handle Submit here
			System.out.println("Not pagetagtype");
			// Submit Form
		}
		userForm.setActorList(getSortedListFromMap(modifiedListMap));
		printValuesinList(getSortedListFromMap(modifiedListMap));
		request.getSession().setAttribute("modifiedListmap", modifiedListMap);
		return mapping.findForward(SUCCESS);
	}

	/**
	 * @param request
	 * @param modifiedListMap
	 */
	private void setValuesInModifiedList(HttpServletRequest request, Map<String, ActorData> modifiedListMap) {
		Enumeration<String> penum = request.getParameterNames();
		if (request.getParameterNames() != null) {
			while (penum.hasMoreElements()) {
				String key = penum.nextElement();
				if (key.indexOf("d-") != -1 && key.indexOf("-p") != -1) {

				} else {
					String tranValue = request.getParameter(key);
					if (null != modifiedListMap.get(key)) {
						if (tranValue.isEmpty()) {
							modifiedListMap.get(key).setOption("optOut");
						} else {
							modifiedListMap.get(key).setOption("optIn");
						}
					}
				}
			}
		}
		request.getSession().setAttribute("modifiedListmap", modifiedListMap);
	}
	/**
	 * @param map
	 * @return
	 */
	private ArrayList<ActorData> getSortedListFromMap(Map<String, ActorData> map) {
		ArrayList<ActorData> list = new ArrayList<ActorData>(map.values());
		Collections.sort((list), new Comparator<ActorData>() {
			@Override
			public int compare(ActorData o1, ActorData o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		return list;
	}
	/**
	 * @param list
	 */
	private void printValuesinList(ArrayList<ActorData> list) {
		for(ActorData actor: list) {
			System.out.println(actor.toString());
		}
	}
}
