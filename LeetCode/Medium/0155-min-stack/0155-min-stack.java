class MinStack {

    class Node{
        int data;
        int min;
        Node next;


        Node(int data, int min){
            this.data = data;
            this.min = min;
            this.next = null;
        }
    }

    private Node top;
    
    

    public MinStack() {
        top = null;

        
        
    }
    
    public void push(int value) {
        if(top == null){
            top = new Node(value , value);
            return;
            
        }
        

        int newMin = Math.min(top.min , value);
        Node newNode = new Node(value , newMin);
        newNode.next = top;
        top = newNode;
        

        
    }
    
    public void pop() {
        top = top.next;
        
    }
    
    public int top() {
        return top.data;
        
        
    }
    
    public int getMin() {
        return top.min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */