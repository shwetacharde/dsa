#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node *next;

    Node(int data)
    {
        this->data = data;
        next = NULL;
    }
};

void print(Node *head)
{
    Node *temp = head;
    while (temp != NULL)
    {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}
Node *reverse(Node *head)
{
    Node *curr = head;
    Node *prev = NULL;
    while (curr != NULL)
    {
        Node *n = curr->next;
        curr->next = prev;
        prev = curr;
        curr = n;
    }
    return prev;
}
Node *takeInput()
{
    int data;
    cout << "Enter elements:" << endl;
    cin >> data;
    Node *head = NULL; /// LL is empty
    Node *tail = NULL; /// LL is empty
    while (data != -1)
    {
        /// creating LL
        Node *n = new Node(data);
        /// 1st node
        if (head == NULL)
        {
            head = n;
            tail = n;
        }
        else
        {
            tail->next = n; /// Inserting at Tail
            tail = n;
        }

        cin >> data;
    }
    return head;
}
int main()
{
    // Note: add -1 at last in input
    Node *head = takeInput(); /// inserting at tail
    head = reverse(head);
    print(head);
    return 0;
}
