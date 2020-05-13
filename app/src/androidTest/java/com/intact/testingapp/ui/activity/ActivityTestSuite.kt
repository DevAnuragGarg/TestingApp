package com.intact.testingapp.ui.activity

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * To organize the execution of your instrumented unit tests, you can group a collection of test
 * classes in a test suite class and run these tests together. Test suites can be nested; your test
 * suite can group other test suites and run all their component test classes together.
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(HomeActivityTest::class, DetailActivityTest::class)
class ActivityTestSuite