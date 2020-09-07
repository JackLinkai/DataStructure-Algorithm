package java.DataStructure.array;

/**
 * 双向链表
 */
public class MyDoubleLinkedList {
    private DNode head; //头
    private DNode tail; //尾

    MyDoubleLinkedList() {
        head = null;
        tail = null;
    }

    //往头部插入数据
    public void insertHead(int data) {
        DNode newDNode = new DNode(data);
        if(head == null){           //链表为空的情况下
            tail=newDNode;
            head=newDNode;
        }else{
            //链表原来的head的前驱指针指向newDNode，newDNode的后继指针指向head
            head.pre=newDNode;
            newDNode.next=head;
        }
        //最终把newDNode作为head结点
        head = newDNode;
    }

    //删除

    //
}

class DNode {
    int value;
    DNode next;
    DNode pre;

    DNode(int value) {
        this.value = value;
        this.next = null;
        this.pre = null;
    }
}