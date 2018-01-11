package com.shop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {
    private List<Node> treeList;
    private Map<String, Node> tree = new HashMap<String, Node>();

    public Tree() {
// TODO Auto-generated constructor stub
    }

    public Tree(List<Node> treeList) {
        this.treeList = treeList;
        this.buildTree();
    }

    private void buildTree() {
        Node root = new Node();
        tree.put("root", root);
        for (int i = 0; i < treeList.size(); i++) {
            Node node = (Node) treeList.get(i);
            if ("0".equals(node.getFather_id())) {
                root.addChild(node);
                tree.put(node.getId(), node);
            } else {
                if (tree.containsKey(node.getFather_id())) {
                    Node parentNode = (Node) tree.get(node.getFather_id());
                    parentNode.addChild(node);
                    tree.put(node.getId(), node);
                } else {
                    tree.put(node.getId(), node);
                }
            }
        }
    }

    public Node getTree() {
        Node node = (Node) tree.get("root");
        return node;
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
//HashMap<String,Node> nodes = new HashMap<String,Node>();
//nodes.put("1",new Node("1","藏书阁","0"));
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node("1", "藏书阁", "0"));//id,name,father_id
        nodes.add(new Node("2", "视频文化", "0"));
        nodes.add(new Node("3", "藏书阁-新书推荐", "1"));
        nodes.add(new Node("4", "原创文学", "0"));
        nodes.add(new Node("5", "藏书阁-读书会活动", "1"));
        nodes.add(new Node("6", "藏书阁-新书推荐-小说", "3"));
        nodes.add(new Node("7", "视频文化-合作伙伴", "2"));
        Tree tree = new Tree(nodes);
        Node root = tree.getTree();
        for (Node node : root.getChildren()) {
            System.out.println("一级ID：" + node.getId());
            System.out.println("一级NAME：" + node.getName());
            for (Node node1 : node.getChildren()) {
                System.out.println("二级ID：" + node1.getId());
                System.out.println("二级NAME：" + node1.getName());
                for (Node node2 : node1.getChildren()) {
                    System.out.println("三级ID：" + node2.getId());
                    System.out.println("三级NAME：" + node2.getName());
                }
            }
        }
    }
}
