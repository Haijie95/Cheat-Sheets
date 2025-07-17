# Software Testing

## Basics

1. What is software testing?

> - Software testing is the process of evaluating and verifying that a software product or application functions
    correctly, securely and efficiently according to it specific requirements.
>- The primary benefits of rocust testing include delivering high-quality software by identifying bugs and improving
   performance.

2. What is this difference between QA and QC?

> - QA is a **Proactive** process so it is a **Prevention** process. Prevent defects during the process. The goal of QA
    is to prevent defects before they occur.
>- QC is a **Reactive** process so it is a **Detection** process. It focuses on identifying defects in the final
   product. QC ensures that the products meets the required standards and specifications.

3. What are the different levels of testing?

> - **Unit Testing** - It focuses on checking individual components or functions of the application to make sure they
    work correctly on their own.
>- **Integration Testing** - This level checks how different modules or components of the software work together. It is
   important because even if individual parts work perfectly, they might face issues when interacting with one another.
>- **System Testing** - This stage checks whether the entire system functions as expected in a real-world environment.
   It includes both functional and non-functional tests to ensure that the software meets customer needs.
>- **Acceptance Testing** - Acceptance testing also known as User Acceptance Testing, is the final test before releasing
   the software to the end-users. In this phase, the customer or end-users verify if the software meets their needs and
   expectations.

4. What is the difference between verification and validation?

> - Verification focuses on building the product correctly according to specifications and requirements. It is the
    process of check that the software achieves its goal without any bugs, and it ensures that the product is developed
    in the right way.
>- Validation focuses on building the right product that meets user needs and expectations, is it the process of
   checking whether the products us up to the mark or in other words, the products has high-level requirements.

5. What is the V-model in testing?

> - V-Model design is a software development approach that pairs each development phase with a corresponding testing
    phase, ensuring quality and alignment from start to finish.
>- It highlights the need to check and validate work at every stage of development.
>- This approach is especially helpful when the project requirements are stable. It allows for a clear and organized
   process.

![Example of V-Model](/Images/VModel.png)

6. What is the STLC and its phases?

> - **STLC** is short form of Software Testing Life Cycle
>- The following are the phases in STLC
>> - **Requirement Analysis**
>>> 1. Review the SRD (Software Requirement Document)
>>>2. Interviewing stakeholders to gather additional information
>>>3. Identifying any ambiguities or inconsistencies in the requirements
>>>4. Identifying any missing or incomplete requirements
>>>5. Identifying any potential risks or issues that may impact the testing process
>>- **Test Planning**
>>> 1. Identifying the testing objectives and scope
>>>2. Developing a test strategy: selecting the testing methods and techniques that will be used
>>>3. Identifying the testing environment and resources needed
>>>4. Estimating the time and cost required for testing
>>>5. Identifying the test deliverables and milestones
>>>6. Assigning roles and responsibilities to the testing team (This is usually fixed based on the team, however the
      tester might change.)
>>>7. Reviewing and approving the test plan (Mostly by test lead.)
>>- **Test Case Development**
>>> 1. Identifying the test cases that will be developed
>>>2. Writing test cases that are clear, concise, and easy to understand
>>>3. Creating test data and test scenarios that will be used in the test cases
>>>4. Identifying the expected results for each test case
>>>5. Reviewing and validating the test cases
>>>6. Updating the requirement traceability matrix (RTM) to map requirements to test cases
>>- **Test Environment Setup**
>>> 1. Test environment decides the conditions on which software is tested. (Usually DEV -> PAT)
>>>2. The developer or the customer creates the testing environment.
>>- **Test Execution**
>>> 1. The test cases and scripts created in the test design stage are run against the software application to identify
       any defects or issues.
>>>2. Any defects or issues that are found during test execution are logged in a defect tracking system, along with
      details such as the severity, priority, and description of the issue.
>>>3. Test data is prepared and loaded into the system for test execution
>>>4. The results of the test execution are analyzed to determine the software's performance and identify any defects or
      issues.
>>>5. Test results are documented and reported to the relevant stakeholders.
>>>6. Any defects that are identified during test execution are retested to ensure that they have been fixed correctly.
>>- **Test Closure**
>>> 1. Test Closure is the final stage of the Software Testing Life Cycle (STLC) where all testing-related activities
       are completed and documented.
>>>2. Ensure that all testing-related activities have been completed and that the software is ready for release.
>>>3. A report is created that summarizes the overall testing process, including the number of test cases executed, the
      number of defects found, and the overall pass/fail rate. This can also be tracked through JIRA ticket.
>>>4. All defects that were identified during testing are tracked and managed until they are resolved. They must also be
      properly linked and can be easily reference to.
>>>5. Knowledge about the software and testing process is shared with the rest of the team and any stakeholders who may
      need to maintain or support the software in the future.

7. What is a testcase and what does it include?

> - A test case is a detailed document or set of instructions used to verify that a specific part of a software
    application works correctly
>- It outlines the steps, inputs, and expected results to determine if a feature meets requirements and functions as
   designed.
>- It usually includes the following:
>> - Test Case ID
>>- Description
>>- Preconditions
>>- Steps
>>- Input Data
>>- Expected Result
>>- Actual Result
>>- Status
>>- Post-conditions

8. What is the difference between test case and test scenario?

> - Test scenarios are high-level descriptions of what should be tested, while test cases are detailed instructions on
    how to test specific functionalities.
>- Basically what is tested and how to test

| Feature         | Test Scenario       | Test Case                                           |
|-----------------|---------------------|-----------------------------------------------------|
| Level of Detail | High-level          | Low-level                                           |
| Scope           | Broad               | Narrow                                              |
| Purpose         | What to test        | How to Test                                         |
| Example         | "User Registration" | "Verify registration with valid email and password" |

9. What is a test plan and what are its components?

> - A test plan is a comprehensive document that outlines the scope, objectives, approach, resources, schedule, and
    deliverables of a software testing process
>- Similar to a release test artifacts
>- It usually includes the following:
>> - **Introduction/Overview** - Provides a summary of the project and the testing effort. Explains the purpose of the
     test plan and its scope.
>>- **Test Items** - Identifies the specific software components, modules, or features that will be tested. Defines what
    is in scope and out of scope for testing.
>>- **Test Objectives** - States the specific goals and targets of the testing process. Outlines what the testing aims
    to achieve in terms of functionality, performance, security, etc
>>- **Test Strategy and Approach** - Describes the overall testing methodology, including the types of testing to be
    performed (e.g., unit testing, integration testing, system testing, user acceptance testing). Specifies the
    techniques, tools, and technologies that will be used.
>>- **Test Environment** - Details the hardware, software, and network configurations needed for testing. Specifies the
    test data requirements and how it will be managed.
>>- **Entry and Exit Criteria** - Defines the conditions that must be met before testing can begin (entry criteria).
    Defines the conditions that must be met for testing to be considered complete (exit criteria).
>>- **Roles and Responsibilities** - Assigns specific roles and responsibilities to team members involved in testing.
    Clearly defines who is responsible for different testing activities.
>>- **Schedule and Timeline** - Outlines the schedule for testing activities, including start and end dates for each
    phase. Specifies milestones and deadlines for testing deliverables.
>>- **Resource Requirements** - Identifies the resources needed for testing, including personnel, tools, and
    infrastructure. Estimates the time, cost, and effort required for testing.
>>- **Risk Management** - Identifies potential risks and challenges that could impact the testing process. Outlines
    mitigation strategies for addressing identified risks.
>>- **Defect Management** - Describes the process for reporting, tracking, and resolving defects found during testing.
    Specifies the tools and procedures for defect management.
>>- **Communication Plan** - Outlines the communication channels and procedures for sharing information between team
    members and stakeholders. Specifies how often updates will be provided and to whom.
>>- **Deliverables** - Lists the specific testing artifacts that will be produced during the testing process (e.g., test
    cases, test scripts, test reports).

10. What is defect life cycle?

## Types of testing

1. What is smoke testing?
2. What is sanity testing?
3. What is regression testing?
4. What is retesting?
5. What is exploratory testing?
6. What is UAT?
7. What is black box testing?
8. What is white box testing?
9. What is grey box testing?
10. What is compatibility testing?

## Bugs reporting and tools

1. What is severity and priority in bugs?
2. How do you log a bug in Jira or any defect management tools?
3. What is the difference between an error, defect and failure?
4. What is the ideal bug report format?
5. What are test metrics?
6. What is the entry and exit criteria in testing?
7. What is the tracebility matrix?
8. What are common test deliverables?
9. What is risk-based testing?
10. What are test environment and test data?

## Agile and real-time scenarios

1. What is agile methodology
2. What is scrum in Agile
3. What is your role in daily stand-up
4. What do you do when requirement changes frequently
5. How do you handle incomplete documentation
6. What if the developer disagrees with your bug
7. How do you estimate test efforts?
8. What if you miss a bug in production?
9. How do you manage testcases for multiple releases?
10. How do you ensure complete test coverage?

## Advance / Conceptual

1. What is shift-left testing?
2. What is static vs dynamic testing?
3. What is test closure?
4. What are the qualities of a good tester?
5. How do you perform risk analysis?
6. What is the role of testing in DevOps?
7. What is the difference between alpha and beta testing?
8. What is usability testing?
9. How do you stay updated in testing field?
10. What challenges do you face in manual testing?



