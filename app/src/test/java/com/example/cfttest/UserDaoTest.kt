package com.example.cfttest

import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cfttest.domain.models.UserDao
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class EmployeeDaoTest {
    private var db: AppDatabase? = null
    private var userDao: UserDao? = null
    @Before
    @Throws(Exception::class)
    fun createDb() {
        db = inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java
        )
            .build()
        userDao = db!!.userDao()
    }

    @After
    @Throws(Exception::class)
    fun closeDb() {
        db!!.close()
    }
}