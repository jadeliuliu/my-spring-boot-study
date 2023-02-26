package com.liuxuan.study;

import com.liuxuan.repository.domain.Student;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.javatuples.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuxuan
 * @date: 2023-02-06 22:32
 **/
public class TupleUtils{

    /**
     * 但元素元祖
     */
    public static <A> Unit<A> with(final A value0) {
        return Unit.with(value0);
    }

    /**
     * 双元素元祖
     */
    public static <A, B> Pair<A, B> with(final A value0, final B value1) {
        return Pair.with(value0, value1);
    }

    /**
     * 三元素元祖
     */
    public static <A, B, C> Triplet<A, B, C> with(final A value0, final B value1, final C value2) {
        return Triplet.with(value0, value1, value2);
    }

    public static void main(String[] args) {
        List<Triplet<Integer, String, String>> roleList = new ArrayList<Triplet<Integer, String, String>>();

        Triplet<Integer, String, String> studentTriplet = TupleUtils.with(11, "sid", "graduate");
        Triplet<Integer, String, String> teacherTriplet = TupleUtils.with(22, "tid", "graduate");
        Triplet<Integer, String, String> programmerTriplet = TupleUtils.with(33, "id", "graduate");

        roleList.add(studentTriplet);
        roleList.add(teacherTriplet);
        roleList.add(programmerTriplet);

        for (Triplet<Integer, String, String> triplet : roleList) {
            System.out.println(triplet);
        }
    }
}