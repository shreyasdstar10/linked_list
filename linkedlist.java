public class linkedlist 
{
    private static node head;

    private static class node
    {
        private int data;
        private node next;

        public node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    public void display(node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+"-->");
            head=head.next;
        }
        System.out.print("null\n");
    }

    public void lenghtoflist()
    {
        int cout=0;
        node curr=head;
        while(curr!=null)
        {
            cout++;
            curr=curr.next;
        }
        System.out.println("Length of list:"+cout);

    }

    public void insertnodeAtBeginning(int data)
    {
        node newnode = new node(data);
        newnode.next=head;
        head=newnode;
    }

    public void insertnodeAtEnd(int data)
    {
        node newnode = new node(data);
        if(head==null)
        {
            head = newnode;
        }
        node curr = head;
        while(curr.next!=null)
        {
            curr=curr.next;
        }
        curr.next=newnode;

    }

    public void insertnodeAtposition(int data , int pos)            //valid position 
    {
        node newnode = new node(data);
        if(pos==1)
        {
            newnode.next=head;
            head=newnode;
        } 
        else
        {
            node priv = head;
            int cnt = 1;
            while(cnt<pos-1)
            {
                priv=priv.next;
                cnt++;
            }
             node curr=priv.next;
             newnode.next=curr;
             priv.next=newnode;
        }
    }

    public node deletefirstnode()
    {
        if(head==null)
        {
            return null;
        }
        node temp = head;
        head=head.next;
        temp.next=null;
        return temp;
    }

    public node deletelastnode()
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        node curr = head;           //current
        node priv = null;           //previous
        while(curr.next!=null)
        {
            priv=curr;
            curr=curr.next;
        }
        priv.next=null;
        return curr;
    }

    public void deletepositionnode(int pos)
    {
        if(pos==1)
        {
            head=head.next;
        }
        else
        {
            node priv = head;
            int cnt = 1;
            while(cnt<pos-1)
            {
                priv=priv.next;
                cnt++;
            }
            node curr = priv.next;
            priv.next=curr.next;
        }
    }

    public Boolean searchdatainlist(int key)
    {
        node curr = head;
        int cnt=1;
        while(curr!=null)
        {
            if(curr.data==key)
            {
                System.out.print("At position:"+cnt+" ");
                return true;
            }
            else
            {
                cnt++;
            }
            curr=curr.next;
        }
        return false;
    }

    public node reverse(node head)
    {
        if(head==null)
        {
            return head;
        }
        node current = head;
        node previous = null ;
        node next = null ;
        while(current!=null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next ;
        }

        return previous ;
    }

    public node midnode()
    {
        if (head==null)
        {
            return null;
        }
        node slowptr=head;
        node fastptr=head;
        while(fastptr !=null && fastptr.next !=null)
        {
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        return slowptr;
    }

    public node nthNodefromlast(int n)            // "n" position from last of linkedlist
    {
        if (head==null)
        {
            return null;
        }

        if(n<=0)
        {
            throw new IllegalArgumentException("Invalid value"+ n);
        }
        node mainptr = head;
        node refptr = head ;

        int cnt=0;
        while(cnt < n)
        {   if(refptr==null)
            {
                throw new IllegalArgumentException(n+ "greater than the number of nodes");
            }  

            refptr = refptr.next;
            cnt++;
        }
        while(refptr != null)
        {
            mainptr=mainptr.next;
            refptr=refptr.next;
        }

        return mainptr;
    }


    public static void main(String[] args) 
    {
        linkedlist l = new linkedlist();
        head= new node(10); //10-->null
        node sec = new node(87);
        node thr = new node(34);
        node four = new node(49);
        node fif = new node(61);

        
        
        head.next=sec;
        sec.next=thr;
        thr.next=four;
        four.next=fif;
        l.display(head);

        l.insertnodeAtBeginning(98);
        l.display(head);

        l.insertnodeAtEnd(344);
        l.display(head);

        l.insertnodeAtposition(3, 3);
        l.display(head);

        System.out.println(l.deletefirstnode().data);
        l.display(head);

        System.out.println(l.deletelastnode().data);
        l.display(head);

        l.deletepositionnode(3);
        l.display(head);

        if(l.searchdatainlist(34))                      //search data in list  
        {
            System.out.println("Found !");
        }
        else
        {
            System.out.println("Not Found !");
        }

        l.display(head);
        node newnode =l.reverse(head);
        l.display(newnode);

        node temp = l.midnode();
        System.out.println("the mid element is :"+temp.data);

        node abc = l.nthNodefromlast(2);
        System.out.println(abc.data);
        
       
    
    }
  
}
