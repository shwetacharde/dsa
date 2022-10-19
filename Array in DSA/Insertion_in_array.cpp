#include<iostream>
using namespace std;
int main()
{
    int arr[6], i, elem;
    cout<<"Enter 5 Array Elements: "<<endl;
    for(i=0; i<5; i++)
        cin>>arr[i];
    cout<<"Enter Element to Insert: "<<endl;
    cin>>elem;
    arr[i] = elem;
    cout<<"The New Array is:";
    for(i=0; i<6; i++)
        cout<<arr[i]<<"  ";
    cout<<endl;
    return 0;
}
