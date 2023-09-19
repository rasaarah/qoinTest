package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import groovy.json.JsonSlurper

public class Common {
	public static JsonSlurper jsonSlurper = new JsonSlurper()

	@Keyword
	def createNewUser(String email, String password) {
		def response = WS.sendRequestAndVerify(findTestObject("Object Repository/POST register successfull",
				["email": email, "password": password]))

		//		println response.getResponseText()
		//		return response

		def jsonResponse = jsonSlurper.parseText(response.getResponseText())
		return jsonResponse.id
	}

	@Keyword
	def static void findUserById(int id) {
		WS.sendRequestAndVerify(findTestObject('Object Repository/GET single user', [('id') : id]))
	}

	@Keyword
	def void getListUsers(int page) {
		def response = WS.sendRequestAndVerify(findTestObject('Object Repository/GET single user', [('page') : page]))
		//		return response
	}
}


















