/**
 * @ClassName LinkList
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/7/26  17:30
 * @Veresion 1.0
 */
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
    public String toString(){
        return String.format(val+" ");
    }
}
public class LinkList {
    //头插
    private static Node pushFront(Node head,int val){
        Node node=new Node(val);
        node.next=head;
        return node;
    }
    //尾插
    private static Node pushBack(Node head,int val){
        Node node=new Node(val);
        if(head==null){
            return node;
        }

        Node cur=head;
        for(;cur.next!=null;cur=cur.next){
            ;
        }
        cur.next=node;
        return head;
    }
    //头删
    private static Node popFront(Node head){
        if(head==null){
            System.err.println("链表为空");
        }
        return head.next;
    }
    //尾删
    private static Node popBack(Node head){
        if(head==null){
            System.err.println("链表为空");
        }
        Node cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }
    //删除链表中给定值的所有节点
    private static Node delelement(Node head,int val){
        if(head==null){
            System.err.println("链表为空");
        }
        Node cur=head;
        Node pre=null;
        while(cur!=null){

            if(cur.val!=val){
                pre=cur;

            }
            else{
                pre.next=cur.next;

            }
            cur=cur.next;
        }
        return head;
    }
    //反转链表
    private static Node reverse(Node head){
        Node result=null;
        Node cur=head;
        while(cur!=null){
            Node next=cur.next;
            cur.next=result;
            result=cur;
            cur=next;
        }
        return result;
    }
    //返回链表的中间节点(两种方法，一种通过快慢引用，一种计数)
    private static Node midNode(Node head){
        Node cur=head;
        Node fast=head;
        Node slow=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null){
                break;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    //输出倒数第k个节点(两种方法，一种通过计数，一种是利用两个引用)
    private static Node lastK(Node head,int k){
        Node fast=head;
        Node slow=head;
        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //将两个有序链表连接
    private static Node conTwo(Node head1,Node head2){
        Node result=null;
        Node cur1=head1;
        Node cur2=head2;
        Node last=null;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                if(result==null){
                    result=cur1;
                }
                else{
                    last.next=cur1;
                }
                last=cur1;
                cur1=cur1.next;
            }
            else{
                if(result==null){
                    result=cur2;
                }
                else{
                    last.next=cur2;
                }
                last=cur2;
                cur2=cur2.next;
            }
        }
        return result;
    }
    //将链表分为两部分
    private static Node DiTwo(Node head,int k){
        Node small=null;
        Node big=null;
        Node smallLast=null;
        Node bigLast=null;
        Node cur=head;
        while(cur!=null){
            if(cur.val<k){
                if(small==null) {
                    small = cur;
                }
                else{
                    smallLast.next=cur;
                }
                smallLast=cur;
                cur=cur.next;
            }
            else{
                if(big==null){
                    big=cur;
                }
                else{
                    bigLast.next=cur;
                }
                bigLast=cur;
                cur=cur.next;
            }
        }
        if(small==null){
            return big;
        }
        else{
            smallLast.next=big;
            if(bigLast.next!=null){
                bigLast.next=null;
            }
        }
        return small;
    }
    //删除重复节点，重复节点不保留
    private static Node deletecom(Node head){
        Node pre=null;
        Node p1=head;
        Node p2=head.next;

        while(p2!=null){
            if(p1.val!=p2.val){
                pre=p1;
                p1=p2;
                p2=p2.next;
            }
            else{
                while(p2!=null&&p1.val==p2.val){
                    p2=p2.next;
                }
                if(pre==null){
                    head=p2;
                }
                else{
                    pre.next=p2;
                }
                p1=p2;
                if(p2!=null){
                    p2=p2.next;
                }
            }
    }
    return head;
    }
    //打印
    private static void print(Node head){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur+"-->");
            cur=cur.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head=null;
        head=pushFront(head,6);
        head=pushFront(head,6);
        head=pushFront(head,4);
        head=pushFront(head,3);
        head=pushBack( head,6);
        head=pushBack( head,7);//3 4 2 6 6 3
        //head=popFront(head);
        //head=popBack(head);
        //delelement(head,2);//6 3 4  4
        //head=reverse(head);
        //head=midNode( head);
        //head=lastK(head,7);
        Node head2=new Node(1);
        Node n3=new Node(5);
        Node n4=new Node(7);
        head2.next=n3;
        n3.next=n4;
       // print(head2);
        print(head);
        //head=conTwo(head,head2);
       // head=DiTwo(head,5);
        head=deletecom(head);
        print(head);
    }
}
