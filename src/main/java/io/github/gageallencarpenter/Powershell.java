package io.github.gageallencarpenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Powershell class provides a convenient way to execute PowerShell scripts synchronously or asynchronously.
 *
 * @author <a href="https://www.linkedin.com/in/gage-carpenter-07750a174/"> Gage </a>
 */
public class Powershell {

    private final ExecutorService executor;

    /**
     * Creates an instance of Powershell with the maximum number of threads based on the runtime environment.
     */
    public Powershell(){
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    }

    /**
     * Creates an instance of Powershell with a specified number of threads.
     *
     * @param threads the number of threads allocated to this Powershell instance
     */
    public Powershell(int threads){
        executor = Executors.newFixedThreadPool(threads);
    }

    /**
     * Executes a PowerShell script synchronously.
     *
     * @param script the PowerShell script to execute
     * @return the list of output lines from the script execution
     */
    public List<String> execute(String script){
        return executeScript(script);
    }

    /**
     * Executes a PowerShell script asynchronously.
     *
     * @param script the PowerShell script to execute
     * @return a Future representing the asynchronous execution with the result containing the list of output lines
     * @throws RuntimeException if an IOException occurs during the script execution
     */
    public Future<List<String>> executeAsync(String script){
        return executor.submit(()-> executeScript(script));
    }

    /**
     * Executes the PowerShell script and returns the output lines.
     *
     * @param script the PowerShell script to execute
     * @return the list of output lines from the script execution
     */
    private List<String> executeScript(String script){
        ArrayList<String> output = new ArrayList<>();
        try{
            ProcessBuilder builder = new ProcessBuilder("powershell.exe","-Command", script);
            builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectError(ProcessBuilder.Redirect.INHERIT);
            builder.redirectOutput(ProcessBuilder.Redirect.PIPE);
            Process process = builder.start();
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = input.readLine()) != null){
                output.add(line);
            }
            return output;
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return output;
    }
}