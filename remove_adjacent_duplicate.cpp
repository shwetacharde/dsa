#include <bits/stdc++.h>
using namespace std;
        string superReducedString(string A) {
        stack<char> s;
         for(int i=0;i<A.size();i++){
             if(s.empty() || A[i] != s.top()){
                 s.push(A[i]);
             } else {
                 s.pop();
             }
         }
        string ans="";
        while(!s.empty()){
            ans.push_back(s.top());
            s.pop();
        }
        
        reverse(ans.begin(),ans.end());
        if(ans.size()==0) return "Empty String";
        return ans;
    }
int main()
{
    string s;
    cout<<"Enter string:"<<endl;
    cin>>s;
    string result = superReducedString(s);
    cout<<result<<"\n";
    return 0;
}
