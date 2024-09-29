package br.edu.fatecourinhos.performance.impl;

import br.edu.fatecourinhos.commons.RunType;
import br.edu.fatecourinhos.commons.SomeObject;
import br.edu.fatecourinhos.commons.Utils;
import br.edu.fatecourinhos.performance.PerformanceTest;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static br.edu.fatecourinhos.commons.Utils.getElapsedTimeMessage;
import static br.edu.fatecourinhos.commons.Utils.getObjectFoundMessage;

public class ComplexPerformanceTestImpl implements PerformanceTest {
    private final long MAX_ITEMS = 7 * 1000000;
    private final SomeObject VALUE_TO_FIND = new SomeObject(31, "Fabio Kamisato", Utils.nextString(20), Utils.nextString(20), Utils.nextString(20));
    private final boolean ADD_ITEM = true;

    @Override
    public void runPerformanceTest(RunType runType) {
        if (runType == null) return;
        Set<SomeObject> someObjectSet = generateObjects();
        if (ADD_ITEM) someObjectSet.add(VALUE_TO_FIND);

        List<SomeObject> someObjectList = new ArrayList<>(someObjectSet);
        Collections.shuffle(someObjectList);

        Map<Integer, SomeObject> hashMap = new HashMap<>();
        someObjectSet.forEach(item -> hashMap.put(item.hashCode(), item));

        System.out.println("List size: " + someObjectList.size());
        System.out.println("Hash size: " + hashMap.size());

        switch (runType) {
            case BOTH -> {
                runHash(hashMap);
                runList(someObjectList);
            }
            case HASH -> runHash(hashMap);
            case LIST -> runList(someObjectList);
        }
    }

    private Set<SomeObject> generateObjects() {
        Set<SomeObject> list = new HashSet<>();
        for (int i = 0; i < MAX_ITEMS; i++) {
            list.add(generateSomeObject());
        }

        return list;
    }

    private SomeObject generateSomeObject() {
        SomeObject someObject = new SomeObject();
        someObject.setFiled1(ThreadLocalRandom.current().nextInt());
        someObject.setField2(Utils.nextString(20));
        someObject.setField3(Utils.nextString(20));
        someObject.setField4(Utils.nextString(20));
        someObject.setField5(Utils.nextString(20));

        return someObject;
    }

    private void runList(List<SomeObject> list) {
        var ini = System.nanoTime();
        var l = list.contains(VALUE_TO_FIND);
        var elapsedTime = System.nanoTime() - ini;
        System.out.println("List contains: " + getElapsedTimeMessage(elapsedTime) + getObjectFoundMessage(l));

        ini = System.nanoTime();
        SomeObject someObject = null;
        for (SomeObject so : list) {
            if (VALUE_TO_FIND.equals(so)) {
                someObject = so;
                break;
            }
        }

        elapsedTime = System.nanoTime() - ini;
        System.out.println("List get: " + getElapsedTimeMessage(elapsedTime) + Objects.requireNonNull(someObject));
    }

    private void runHash(Map<Integer, SomeObject> hashMap) {
        var ini = System.nanoTime();
        var l = hashMap.containsKey(VALUE_TO_FIND.hashCode());
        var elapsedTime = System.nanoTime() - ini;
        System.out.println("HashMap contains: " + getElapsedTimeMessage(elapsedTime) + getObjectFoundMessage(l));

        ini = System.nanoTime();
        var someObject = hashMap.get(VALUE_TO_FIND.hashCode());
        elapsedTime = System.nanoTime() - ini;
        System.out.println("HashMap get: " + getElapsedTimeMessage(elapsedTime) + someObject);
    }

}
