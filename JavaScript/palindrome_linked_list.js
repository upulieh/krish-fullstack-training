class Node {
  constructor(element) {
    this.element = element;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.size = 0;
  }

  add(element) {
    var node = new Node(element);
    var current;
    if (this.head == null)
      //For first element
      this.head = node;
    else {
      current = this.head; // Iterate till the last item and add value
      while (current.next) {
        current = current.next;
      }
      current.next = node;
    }
    this.size++;
  }

  reverseList() {
    var current = this.head,
      prev = null,
      next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    this.head = prev;
    return this;
  }

  printList() {
    var curr = this.head;
    var str = '';
    while (curr) {
      str += curr.element + ' ';
      curr = curr.next;
    }
    console.log(str);
    return str;
  }
}

let list = new LinkedList();

list.add(10);
list.add(20);
list.add(30);
list.add(20);
list.add(10);

if (list.printList() == list.reverseList().printList()) {
  console.log('Linked list is a palindrome');
} else {
  console.log('Linked list is not a palindrome');
}
