package br.edu.fatecourinhos.main;

import br.edu.fatecourinhos.commons.RunType;
import br.edu.fatecourinhos.performance.PerformanceTest;
import br.edu.fatecourinhos.performance.impl.ComplexPerformanceTestImpl;
import br.edu.fatecourinhos.performance.impl.SimplePerformanceTestImpl;

public class Main {
    public static void main(String[] args) {
        var runSimple = true;
        PerformanceTest performanceTest = runSimple ? new SimplePerformanceTestImpl() : new ComplexPerformanceTestImpl();
        performanceTest.runPerformanceTest(RunType.BOTH);
    }
}