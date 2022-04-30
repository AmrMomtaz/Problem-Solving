//
// Created by Momtaz on 30/4/2022.
//

#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

string caesarCipher(string s, int k) {
    char A_code = 65; char a_code = 97;
    char Z_code = 90; char z_code = 122;
    for (int i = 0 ; i < s.length() ; i++){
        if((s[i] >= A_code && s[i] <= Z_code)||
                (s[i] >= a_code && s[i] <= z_code)){
            if(s[i]<= Z_code)
                s[i] = ((s[i] - A_code + k)%26)+A_code;
            else
                s[i] = ((s[i] - a_code + k)%26)+a_code;
        }
    }
    return s;
}

int main()
{
    ofstream fout("output.txt");

    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));

    string s;
    getline(cin, s);

    string k_temp;
    getline(cin, k_temp);

    int k = stoi(ltrim(rtrim(k_temp)));

    string result = caesarCipher(s, k);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
            s.begin(),
            find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
            find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
            s.end()
    );

    return s;
}
