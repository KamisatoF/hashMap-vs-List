package br.edu.fatecourinhos.main;

import br.edu.fatecourinhos.commons.RunType;
import br.edu.fatecourinhos.performance.PerformanceTest;
import br.edu.fatecourinhos.performance.impl.ComplexPerformanceTestImpl;
import br.edu.fatecourinhos.performance.impl.SimplePerformanceTestImpl;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var argList = Arrays.asList(args);
        var runSimple = true;
        if (argList.size() == 1)
            runSimple = "true".equals(argList.getFirst());

        PerformanceTest performanceTest = runSimple ? new SimplePerformanceTestImpl() : new ComplexPerformanceTestImpl();
        performanceTest.runPerformanceTest(RunType.BOTH);
    }
}
