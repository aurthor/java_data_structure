package com.list;

/**
 * 模拟双链表的实现
 * 2020/7/11 0011
 */
public class DoubleLinkedList {
    /**
     * 首节点
     */
    private Node headNode;
    /**
     * 尾节点
     */
    private Node lastNode;
    /**
     * 链表长度
     */
    private int size;

    /**
     * 获取链表长度
     * @return 链表长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     * @param element 添加的元素
     */
    public void add(Object element) {
        // 封装成节点对象
        Node node = new Node(element);
        // 判断是否是第一次插入
        if (headNode == null) {
            // 第一次插入设置元素为首节点
            headNode = node;
            // 第一次插入设置元素为尾节点
            lastNode = node;
        } else {
            // 尾节点的后驱指向添加元素的节点
            lastNode.nextNode = node;
            // 把添加元素的节点前驱指向尾节点
            node.preNode = lastNode;
            // 把尾节点设置成添加元素节点
            lastNode = node;
        }
        // 更新链表长度
        size++;
    }

    /**
     * 获取索引处节点元素
     * @param index 索引
     * @return 元素
     */
    public Object get(int index) {
        // 索引检查
        rangeCheck(index);
        // 获取索引处节点
        Node node = node(index);
        return node.getData();
    }
    /**
     * 删除索引处元素
     * @param index 索引
     */
    public void remove(int index) {
        // 索引检查
        rangeCheck(index);
        // 处理index=0，删除首节点的情况
        if (index == 0) {
            // 获取首节点的下一个节点
            Node nextNode = headNode.nextNode;
            // 设置首节点的下一个节点为空
            headNode.setNextNode(null);
            // 设置nextNode的前一节点为空
            if (nextNode != null) {
                nextNode.setPreNode(null);
            }
            // 把nextNode设置为首节点
            headNode = nextNode;
        } else if (index == size-1) {
            // 处理index=size-1，删除尾节点的情况，获取尾节点的前一节点
            Node preNode = lastNode.preNode;
            // 把尾节点的前驱设置为空
            lastNode.preNode = null;
            // 设置preNode的下一节点为空
            preNode.nextNode = null;
            // 把preNode设置为尾节点
            lastNode = preNode;
        } else {
            // 处理节点在中间的情况，获取索引处节点
            Node node = node(index);
            // 获取索引处前驱节点
            Node preNode = node.preNode;
            // 获取索引处后继节点
            Node nextNode = node.nextNode;
            // 置空索引前驱和后继
            node.preNode = null;
            node.nextNode = null;
            // 设置前驱的后继节点为nextNode
            preNode.nextNode = nextNode;
            // 设置后继的前驱节点为preNode
            nextNode.preNode = preNode;
        }
        // 更新链表长度
        size--;
    }

    /**
     * 指定索引处添加元素
     * @param index 索引
     * @param element 元素
     */
    public void add(int index,Object element) {
        // 索引检查
        rangeCheck(index);
        // 将添加的元素封装成节点对象
        Node node = new Node(element);
        // 处理index=0，插入节点在首节点的情况
        if (index == 0) {
            // 设置插入的节点的后继为首节点
            node.setNextNode(headNode);
            // 设置首节点的前驱为插入节点
            headNode.setPreNode(node);
            // 把插入节点设置为shoujied
            headNode = node;
        } else if (index == size-1) {
            // 处理index=size-1，插入节点在末尾的情况，设置尾节点的后继为插入节点
            lastNode.setNextNode(node);
            // 设置插入节点的前驱为尾节点
            node.setPreNode(lastNode);
            // 把插入节点设置为尾节点
            lastNode = node;
        } else {
            // 处理插入在中间的情况，获取索引处节点
            Node indexNode = node(index);
            // 获取索引节点的前驱
            Node preNode = indexNode.preNode;
            // 设置索引节点前驱为插入节点
            indexNode.setPreNode(node);
            // 设置插入节点的后继为索引节点
            node.setNextNode(indexNode);
            // 设置preNode的后继为插入节点
            preNode.setNextNode(node);
            // 设置插入节点的前驱为preNode节点
            node.setPreNode(preNode);
        }
        // 更新链表长度
        size++;
    }
    /**
     * 获取索引处节点
     * @param index 索引
     * @return 索引处节点
     */
    public Node node(int index) {
        // 索引检查
        rangeCheck(index);
        // 定义临时节点
        Node tempNode = headNode;
        for (int i = 0; i < index; i++) {
            // 获取索引位置节点
            tempNode = tempNode.nextNode;
        }
        return tempNode;
    }
    /**
     * 检查索引是否合法
     * @param index 索引
     */
    public void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引不合法："+index);
        }
    }
    /**
     * 节点类
     */
    class Node {
        /**
         * 节点数据
         */
        private Object data;
        /**
         * 上一个节点的地址
         */
        private Node preNode;
        /**
         * 下一个节点的地址
         */
        private Node nextNode;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getPreNode() {
            return preNode;
        }

        public void setPreNode(Node preNode) {
            this.preNode = preNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "headNode=" + headNode +
                ", lastNode=" + lastNode +
                ", size=" + size +
                '}';
    }
}
