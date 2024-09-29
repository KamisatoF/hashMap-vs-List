package br.edu.fatecourinhos.performance.impl;

import br.edu.fatecourinhos.commons.RunType;
import br.edu.fatecourinhos.performance.PerformanceTest;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static br.edu.fatecourinhos.commons.Utils.getElapsedTimeMessage;
import static br.edu.fatecourinhos.commons.Utils.getObjectFoundMessage;

public class SimplePerformanceTestImpl implements PerformanceTest {
    private final long VALUE_TO_FIND = 10L;
    private final boolean ADD_ITEM = true;
    private final long MAX_ITEMS = 50 * 1000000;

    @Override
    public void runPerformanceTest(RunType runType) {
        if (runType == null) return;
        Set<Long> hashSet = new HashSet<>();
        ThreadLocalRandom.current().longs(MAX_ITEMS).forEach(hashSet::add);
        if (ADD_ITEM) hashSet.add(VALUE_TO_FIND);
        var list = new ArrayList<>(hashSet);
        Collections.shuffle(list);

        System.out.println("List size: " + list.size());
        System.out.println("Hash size: " + hashSet.size());

        switch (runType) {
            case BOTH -> {
                runHashSet(hashSet);
                runList(list);
            }
            case HASH -> runHashSet(hashSet);
            case LIST -> runList(list);
        }
    }

    private void runList(List<Long> list) {
        var ini = System.nanoTime();
        var isFound = list.contains(VALUE_TO_FIND);
        var elapsedTime = System.nanoTime() - ini;
        System.out.println("List contains: " + getElapsedTimeMessage(elapsedTime) + getObjectFoundMessage(isFound));
    }

    private void runHashSet(Set<Long> hashSet) {
        var ini = System.nanoTime();
        var isFound = hashSet.contains(VALUE_TO_FIND);
        var elapsedTime = System.nanoTime() - ini;
        System.out.println("HashSet contains: " + getElapsedTimeMessage(elapsedTime) + getObjectFoundMessage(isFound));
    }

}
