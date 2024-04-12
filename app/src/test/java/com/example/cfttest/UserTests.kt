package com.example.cfttest

import com.example.cfttest.domain.models.User
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

class UserTests {
    @Test
    fun testUserCreation() {
        val user = User(
            uid = 1,
            gender = "male",
            location = "New York",
            longitude = "40.7128",
            latitude = "74.0060",
            name = "John Doe",
            email = "johndoe@example.com",
            login = "johndoe",
            dob = "1990-01-01",
            age = 34,
            registered = "2010-01-01",
            registeredAge = 24,
            phone = "1234567890",
            cell = "0987654321",
            id = "ABC123",
            picture = "https://example.com/johndoe.jpg",
            nat = "US"
        )
        assertEquals(1, user.uid)
    }

    @RunWith(Parameterized::class)
    class UserParameterizedTests(
        private val input: String,
        private val expected: String
    ) {
        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun data(): Collection<Array<String>> {
                return listOf(
                    arrayOf("John", "John"),
                    arrayOf("Doe", "Doe"),
                    arrayOf("male", "male")
                )
            }
        }
        @Test
        fun testParameters() {
            assertEquals(expected, input)
        }
    }
}