# MiniProject-ManualTesting-AutomationTesting
Comprehensive QA project demonstrating test planning, automation (Selenium &amp; REST Assured), and end-to-end software testing practices.

# **Quality Assurance Testing – Resonance Website**

## **Overview**

This repository showcases an end-to-end Quality Assurance (QA) implementation for the Resonance Website, a platform used to report and manage issue tickets.
The project covers **manual testing**, **UI automation**, **API automation**, and **regression testing** to ensure application quality, reliability, and stability.

---

## **Objectives**

* Validate core functionalities: **Login** and **Create Ticket**
* Ensure the system behaves correctly under positive and negative scenarios
* Automate testing processes to improve efficiency and coverage
* Identify and document defects with clear and structured reporting

---

## **Testing Scope**

### **1. Login Feature**

* Valid login
* Empty credentials
* Wrong username
* Wrong password

### **2. Create Ticket Feature**

* Create ticket with complete data
* Create ticket without description
* Create ticket with empty data
* Create ticket without title

---

## **Testing Approach**

### **Manual Testing**

* Functional Testing
* Positive & Negative Testing
* UI Testing

### **Automation Testing**

* **UI Automation** using Selenium
* **API Automation** using REST Assured

### **Other Testing**

* Smoke Testing
* Regression Testing

---

## **Tech Stack**

* **Language**: Java
* **UI Automation**: Selenium
* **API Automation**: REST Assured
* **Test Framework**: TestNG
* **IDE**: IntelliJ IDEA
* **Test Case Management**: Microsoft Excel
* **Reporting**: Extent Reports

---

## **📊 Test Results Summary**

| Testing Type       | Total | Passed | Failed |
| ------------------ | ----- | ------ | ------ |
| Manual Testing     | 8     | 8      | 0      |
| UI Automation      | 8     | 8      | 0      |
| API Automation     | 5     | 5      | 0      |
| Regression Testing | 8     | 8      | 0      |

✅ **Overall Result: 100% Passed**

---

## **🐞 Defect Summary**

Although all test cases passed, several improvement points were identified:

* API returns **500 Internal Server Error** for empty/invalid input (should be 401 unauthorized)

---

## **📁 Project Structure**

```
├── testcases/          # Manual test cases (Excel)
├── automation/
│   ├── ui/             # Selenium test scripts
│   └── api/            # REST Assured test scripts
├── reports/            # Extent Reports
├── bug-report/         # Defect documentation
└── README.md
```

---

## **How to Run Tests**

### **UI Automation (Selenium)**

```comand prompt
./gradlew clean test "-Psuite=smoke.xml" "-Penv=staging"
```

### **API Automation (REST Assured)**

```run configuration Gradle :
* Login test :
* name = LoginTest.loginDataDriven
* run = :test --tests "tests.LoginTest.loginDataDriven"

* Create ticket test :
* name : CreateTicketTest.createTicket
* run = :test --tests "tests.CreateTicketTest.createTicket"
```

---

## **📌 Key Highlights**

* End-to-end QA process implementation
* Combination of **manual & automation testing**
* Data-driven testing approach
* Structured bug reporting
* Professional QA documentation

---

## **QA Recommendations**

* Improve API error handling (use proper HTTP status codes)
* Expand test coverage with edge cases and negative scenarios

---

## **👤 Author**

Farras Adani As Shidiq
