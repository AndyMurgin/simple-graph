package com.amurgin.graphs.core;

import com.amurgin.graphs.api.Edge;

import java.util.Objects;

/**
 * Used as graphs edge entity in case when there is no need in
 * specific user-defined class associated with graph edges.
 *
 * Isn't intended to be instantiate by clients.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultEdge that = (DefaultEdge) o;
        return Objects.equals(source, that.source) &&
                Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}
