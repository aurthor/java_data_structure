package com.list;

/**
 * 模拟环形单链表的实现
 * 2020/7/12 0012
 */
public class CycleSingleLinkedList {
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
     * @return 节点个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     * @param element 元素
     */
    public void add(Object element) {
        // 封装成节点对象
        Node node = new Node(element);
        // 判断首节点是否为空
        if (headNode == null) {
            // 首节点为空，第一次添加将元素设置为首节点
            headNode = node;
            // 把元素设置为尾节点
            lastNode = node;
        } else {
            // 首节点不为空，让当前尾节点指向元素节点
            lastNode.next = node;
            // 把元素节点设置为尾节点
            lastNode = node;
        }
        // 设置尾节点的后继为首节点
        lastNode.next = headNode;
        // 更新节点长度
        size++;
    }

    /**
     * 指定索引处添加元素
     * @param index 索引
     * @param element 元素
     */
    public void add(int index,Object element) {
        // 检查索引
        rangeCheck(index);
        // 封装成节点对象
        Node node = new Node(element);
        // 处理index=0，删除首节点的情况
        if(index == 0) {
            // 设置插入节点的后继为headNode
            node.next = headNode;
            // 把插入节点设置为首节点
            headNode = node;
            // 尾节点的后继指向首节点
            lastNode.next = headNode;
        } else if(index == size) {
            // 处理插入节点在末尾位置的情况，尾节点的后继设置为插入节点
            lastNode.next = node;
            // 设置插入节点为单链表的尾节点
            lastNode = node;
            // 尾节点的后继指向首节点
            lastNode.next = headNode;
        } else {
            // 处理插入节点在中间位置的情况，获得index-1所对应的节点对象
            Node preNode = node(index - 1);
            // 获得index所对应的节点对象
            Node curNode = preNode.next;
            // 设置preNode的next为node
            preNode.next = node;
            // 设置node的next为curNode
            node.next = curNode;
        }
        // 更新链表长度
        size++;
    }

    /**
     * 获取索引处元素
     * @param index 索引
     * @return 元素
     */
    public Object get(int index) {
        // 检查索引
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
        // 检查索引
        rangeCheck(index);
        // 处理index=0，删除首节点的情况
        if (index == 0) {
            // 获取删除节点的后继
            Node nextNode = headNode.next;
            // 设置首节点的后继为空
            nextNode.setNext(null);
            // 设置尾节点的后继为nextNode
            lastNode.setNext(nextNode);
            // 把nextNode设置为首节点
            headNode = nextNode;
        } else if (index == size-1) {
            // 处理index=size-1，删除尾节点的情况，获取尾节点的前一节点
            Node preNode = node(index - 1);
            // 设置尾节点的后继为空
            lastNode.setNext(null);
            // 把preNode设置为尾节点
            lastNode = preNode;
            // 设置preNode的后继为headNode
            preNode.setNext(headNode);
        } else {
            // 处理在链表中间的情况，获取索引前面元素
            Node preNode = node(index - 1);
            // 获取索引后继节点
            Node nextNode = preNode.next.next;
            // 设置删除索引的后继为空
            preNode.getNext().setNext(null);
            // preNode的后继设置为nextNode
            preNode.setNext(nextNode);

        }
    }
    /**
     * 检查索引是否合法
     * @param index 索引
     */
    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引不合法："+index);
        }
    }
    /**
     * 根据序号获得对应的节点对象
     * @param index 序号
     * @return 序号对应的节点对象
     */
    private Node node(int index) {
        // 判断环形单链表是否为空表
        if(headNode == null) {
            throw new NullPointerException("环形单链表为空表");
        }
        // 检查索引
        rangeCheck(index);
        // 定义一个零时节点，用于辅助单链表的遍历操作
        Node tempNode = headNode;
        // 定义一个循环，用于获取index对应的节点对象
        for(int i = 0; i < index; i++) {
            // 3.更新tempNode的值
            tempNode = tempNode.next;
        }
        // 返回index对应的节点对象
        return tempNode;
    }
    class Node {
        /**
         * 节点数据
         */
        private Object data;
        /**
         * 后继节点
         */
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
