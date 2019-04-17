package com.amurgin.graphs.core;

import com.amurgin.graphs.api.Edge;

public class DefaultEdge implements Edge<Object> {

    private Object source;
    private Object target;

    DefaultEdge(Object source, Object target) {
        this.source = source;
        this.target = target;
    }

    private DefaultEdge(){
    }

    static DefaultEdge empty() {
        return new DefaultEdge();
    }

    @Override
    public Object getSource() {
        return source;
    }

    @Override
    public Object getTarget() {
        return target;
    }

    @Override
    public Edge<Object> revert() {
        return new DefaultEdge(target, source);
    }

    @Override
    public String toString() {
        return "DefaultEdge{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }
}
