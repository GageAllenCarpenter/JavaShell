import org.java.shell.Powershell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

public class PowershellTest {
    private Powershell powershell;

    @BeforeEach
    void setUp() {
        powershell = new Powershell();
    }

    @Test
    void testExecuteSynchronously() {
        String script = "Write-Host 'Hello, World!'";
        List<String> output = powershell.execute(script);
        assertNotNull(output);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).contains("Hello, World!"));
    }

    @Test
    void testExecuteAsynchronously() throws ExecutionException, InterruptedException {
        String script = "Write-Host 'Async Hello, World!'";
        Future<List<String>> futureOutput = powershell.executeAsync(script);
        assertNotNull(futureOutput);

        List<String> output = futureOutput.get();
        assertNotNull(output);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).contains("Async Hello, World!"));
    }
}
