import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CollatzTest {

    @Test
    fun testCollatzSimple() {
        val result = collatzSequence(6)
        assertEquals(listOf<Long>(6, 3, 10, 5, 16, 8, 4, 2, 1), result)
    }

    @Test
    fun testCollatzOne() {
        assertEquals(listOf<Long>(1), collatzSequence(1))
    }

    @Test
    fun testInvalidInput() {
        assertFailsWith<IllegalArgumentException> {
            collatzSequence(0)
        }
    }
}

