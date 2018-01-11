package com.shop.util;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id;
    private String name;
    private String father_id;
    private int level;
    private List<Node> children;

    public Node() {
        this.id = "root";
        this.name = "树";
        this.children = new ArrayList<Node>();
    }

    public Node(String id, String name, String father_id) {
        this.id = id;
        this.name = name;
        this.father_id = father_id;
        this.children = new ArrayList<Node>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_id() {
        return father_id;
    }

    public void setFather_id(String fatherId) {
        father_id = fatherId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }
}
