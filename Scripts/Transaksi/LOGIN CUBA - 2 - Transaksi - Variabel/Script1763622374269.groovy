import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.cura)

WebUI.click(findTestObject('Object Repository/Login/a_Make Appointment'))

WebUI.click(findTestObject('Object Repository/Login/input Username'))

WebUI.setText(findTestObject('Object Repository/Login/Page_CURA Healthcare Service/input_Username_username'), GlobalVariable.username)

WebUI.setText(findTestObject('Login/Input Password'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Login/Input Password'))

WebUI.click(findTestObject('Object Repository/Login/Page_CURA Healthcare Service/form_Demo account                          _b80bac'))

WebUI.click(findTestObject('Object Repository/Login/button_Login'))

WebUI.delay(2)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Login/MessageErrorLogin'), 0, FailureHandling.OPTIONAL)) {
    println('message error ditemukan')
} else if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'), 
    0, FailureHandling.OPTIONAL)) {
    println('login berhasil')
}

if (readmission == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/readmission'))

    println('Pakai Readmission')
} else {
    println('Tanpa Readmission')
}

if (program == 'Medicare') {
    WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/label_Medicare'))
} else if (program == 'Medicaid') {
    WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/label_Medicaid'))
} else if (program == 'None') {
    WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/label_None'))
}

//WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/readmission'))
//
//WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/input_Medicaid_programs'))
WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/div_Visit Date (Required)_input-group-addon'))

WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/td_30'))

WebUI.setText(findTestObject('Transaksi/Page_CURA Healthcare Service/Comment', [('variable') : program]), program)

WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.verifyElementPresent(findTestObject('Transaksi/Page_CURA Healthcare Service/h2_Appointment Confirmation'), 0)

WebUI.verifyElementPresent(findTestObject('Transaksi/Page_CURA Healthcare Service/Verify Program', [('program') : program]), 
    0)

//if (program == 'Medicare') {
//    WebUI.verifyElementPresent(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/Verify Program Medicare'), 
//        0)
//
//    println('Medicare')
//} else if (program == 'Medicaid') {
//    WebUI.verifyElementPresent(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/Verify Program Medicaid'), 
//        0)
//
//    println('Medicaid')
//} else if (program == 'None') {
//    WebUI.verifyElementPresent(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/Verify Program None'), 
//        0)
//
WebUI.comment("program $program yang dipilih")

//}
WebUI.click(findTestObject('Object Repository/Transaksi/Page_CURA Healthcare Service/a_Go to Homepage'))

WebUI.delay(2)

WebUI.closeBrowser()

