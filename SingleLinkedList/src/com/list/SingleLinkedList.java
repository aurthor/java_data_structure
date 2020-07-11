package com.list;

/**
 * 模拟单链表的实现
 * 2020/7/11 0011
 */
public class SingleLinkedList {
    /**
     * 首节点
     */
    private Node headNode;

    /**
     * 尾节点
     */
    private Node lastNode;

    /**
     * 链表节点的个数
     */
    private int size;

    /**
     * 添加元素
     * @param element
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
        // 更新节点长度
        size++;
    }

    /**
     * 删除索引处节点
     * @param index
     */
    public void remove(int index) {
        // 检查索引
        rangeCheck(index);
        // 处理索引为0的情况（删除首节点）
        if (index == 0) {
            // 获取首节点的下一个节点
            Node next = headNode.getNext();
            // 设置首节点的下一节点为null
            headNode.setNext(null);
            // 设置next为首节点
            headNode = next;
        } else if (index == size-1) {
            //处理索引为size-1（删除尾节点），获取删除节点的前一节点
            Node preNode = node(index - 1);
            // 设置preNode的下一节点为null
            preNode.setNext(null);
            // 把preNode设置为尾节点
            lastNode = preNode;
        } else {
            // 处理索引为中间的情况，获取删除节点的前一个节点
            Node preNode = node(index - 1);
            // 获取删除节点的下一个节点
            Node nextNode = preNode.getNext().getNext();
            // 把前一节点的下一个节点设置为删除节点的下一节点
            preNode.setNext(nextNode);
        }
        // 更新节点长度
        size--;
    }

    /**
     * 指定索引处添加元素
     * @param index
     * @param e
     */
    public void add(int index,Object e) {
        // 检查索引
        rangeCheck(index);
        // 将添加的元素封装成节点对象
        Node node = new Node(e);
        // 处理索引为0，首节点插入的情况
        if (index == 0) {
            // 设置插入的元素的下一节点为首节点
            node.setNext(headNode);
            // 将node设置为首节点
            headNode = node;
        } else if (index == size-1) {
            // 处理索引为index-1,尾节点插入的情况
            // 设置尾节点的下一节点为插入的元素
            lastNode.setNext(node);
            // 把插入的元素设置为尾节点
            lastNode = node;
        } else {
            // 链表中间插入的情况
            // 获取插入节点的前一节点
            Node preNode = node(index - 1);
            // 获取插入索引的节点
            Node nextNode = node(index);
            // 设置前一节点的下一节点为插入元素
            preNode.setNext(node);
            // 设置插入节点的下一节点为索引节点
            node.setNext(nextNode);

        }
        // 更新节点的长度
        size++;
    }
    /**
     * 根据索引取得节点对象
     * @param index
     * @return
     */
    public Node node(int index) {
        // 检查索引
        rangeCheck(index);
        // 定义临时节点，取得索引位置的节点
        Node tempNode = headNode;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }
    /**
     * 根据索引取值
     * @param index
     * @return
     */
    public Object get(int index) {
        rangeCheck(index);
        // 获取索引处节点
        Node node = node(index);
        // 取得节点元素
        return node.getElement();
    }
    /**
     * 检查索引是否合法
     * @param index
     */
    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引不合法："+index);
        }
    }

    /**
     * 获取单链表长度
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 节点对象
     */
    class Node {
        /**
         * 保存节点数据
         */
        private Object element;
        /**
         * 指向下一节点的地址（前驱）
         */
        private Node next;

        public Object getElement() {
            return element;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Object element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "headNode=" + headNode +
                ", lastNode=" + lastNode +
                ", size=" + size +
                '}';
    }
}
