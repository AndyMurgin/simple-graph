package com.amurgin.graphs.core;

import com.amurgin.graphs.api.Edge;

public class DefaultEdge implements Edge<Object> {

    private Object start;
    private Object end;

    DefaultEdge(Object start, Object end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Object getStart() {
        return start;
    }

    @Override
    public Object getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "DefaultEdge{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
