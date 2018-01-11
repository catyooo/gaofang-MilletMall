package com.shop.util;

import java.util.ArrayList;
import java.util.List;

public class CategoryNode {
    private Long categoryId;

    private Long parentId;

    private String name;

    private List<CategoryNode> children;

    public CategoryNode() {
        this.categoryId = 1L;
        this.name = "全部商品";
        this.children = new ArrayList<CategoryNode>();
    }

    public CategoryNode(Long categoryId, Long parentId, String name) {
        this.categoryId = categoryId;
        this.parentId = parentId;
        this.name = name;
        this.children = new ArrayList<CategoryNode>();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryNode> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryNode> children) {
        this.children = children;
    }

    public void addChild(CategoryNode node) {
        this.children.add(node);
    }

    @Override
    public String toString() {
        return "CategoryNode{" +
                "categoryId=" + categoryId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", children=" + children.size() +
                '}';
    }
}
