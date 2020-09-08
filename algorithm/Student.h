//
// Created by Clark on 2020-09-03.
//

#include "iostream"
#include "string"
using namespace std;
#ifndef ALGORITHM_STUDENT_H
#define ALGORITHM_STUDENT_H



struct Student{
    string name ;
    int age;

    bool operator <(const Student& o){
        return age == o.age? name < o.name : age < o.age;
    }

    friend ostream& operator <<(ostream& os, const Student& o){
        os<<"The name is "<<o.name<< " age is "<< o.age<<endl;
        return os;
    }


//    bool operator <(const Student& other){
//        return age < other.age;
//    }
//
//    friend ostream& operator<<(ostream& o, const Student& student){
//        o<<"Stduent "<<student.name<<" age: "<<student.age<<endl;
//        return o;
//    }

};








#endif //ALGORITHM_STUDENT_H
