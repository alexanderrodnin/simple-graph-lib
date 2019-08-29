package com.alexanderrodnin.simplegraphlib.finder;

import com.alexanderrodnin.simplegraphlib.model.GraphModel;

import java.util.*;

public class FirstFoundPathFindStrategy<Vertex> implements PathFindStrategy<Vertex> {

    private static class Wrapper<T> {
        private T value;
        private Wrapper(T value) {
            this.value = value;
        }
        private T getValue() {
            return value;
        }
        private void setValue(T value) {
            this.value = value;
        }
    }

    public List<Vertex> findPath(GraphModel<Vertex> graphModel, Vertex source, Vertex destination) {
        Wrapper<List<Vertex>> firstFoundPath = new Wrapper<>(new ArrayList<>());
        recursiveFind(firstFoundPath, graphModel, source, destination, new LinkedHashSet<>());

        return firstFoundPath.getValue();
    }

    private void recursiveFind(
            Wrapper<List<Vertex>> firsFoundPath,
            GraphModel<Vertex> graphModel,
            Vertex current,
            Vertex destination,
            LinkedHashSet<Vertex> path
    ) {
        if (firsFoundPath.getValue().isEmpty()) {
            path.add(current);

            if (current.equals(destination)) {
                firsFoundPath.setValue(new ArrayList<>(path));
            } else {
                for (Vertex nearest : graphModel.getEdgedVertices(current)) {
                    if (!path.contains(nearest)) {
                        recursiveFind(firsFoundPath, graphModel, nearest, destination, path);
                    }
                }
            }

            path.remove(current);
        }
    }
}
