// 참고사이트 - https://popcorn16.tistory.com/128
// // 전체 값 들고오기
// let url = "http://localhost:8090/sel?val=학생";
// let xhr = new XMLHttpRequest();
// xhr.open('GET', url);
// xhr.onload = () => {
//     console.log(xhr.response.nm);
// };
// xhr.send();
// 하나의 값 들고오기
// let url = "http://localhost:8090/sel?val=학생";
// let xhr = new XMLHttpRequest();
// xhr.open('GET', url)
// xhr.responseType = 'json';
// xhr.onload = () => {
//     console.log(xhr.response[1].nm);
// };
// xhr.send();

var arry=[];
function getNM() {
    let url = "http://localhost:8090/sel?val=학생";
    let xhr = new XMLHttpRequest();
    xhr.open('GET', url)
    xhr.responseType = 'json';
    xhr.onload = () => {
        let data = xhr.response;
        for(let i = 0; i<data.length; i++){
            arry[i] = data[i].nm;
        }
        addElementLsit()
    };
    xhr.send();
}
getNM()
var arry2=[];
function getNM2() {
    let url = "http://localhost:8090/sel?val=그룹";
    let xhr = new XMLHttpRequest();
    xhr.open('GET', url)
    xhr.responseType = 'json';
    xhr.onload = () => {
        let data = xhr.response;
        for(let i = 0; i<data.length; i++){
            arry2[i] = data[i].gp;
        }
        addElementLsit()
    };
    xhr.send();
}
getNM2()


function addElementLsit() {

    let studentList = document.getElementById('studentList');
    let newUl = document.createElement('ul') // ul 생성

    for(let i = 0; i< arry.length; i++){
        let newLi = document.createElement('li') // li 생성
        newLi.id = "nmLi"+i; // id값 추가
        newLi.innerText=arry[i]; // text 추가
        studentList.appendChild(newUl).appendChild(newLi);
    }
}

function makegroup(){
    let li= [];
    let rm,rm2 ;
    let conut1,conut2, conut3;
    for(let i = 0; i <arry.length; i++) {
        li[i] = document.getElementById('nmLi' + i).innerText;
    }

    rm=rmNm(); // nm 랜덤 화.
    rm2 =rmGp()
    console.log(rm)
    console.log(rm2)

    for(let i =0, j =0; i<li.length; i++) {
        makeJson(rm[i]+1, arry2[rm2[j++]])

        if(j>2){
            j=0
        }
    }
}
function rmNm(){
    let rm , rm2 = 0, arr1;
    let arr =[]
    while (true){
        arr[rm2] = Math.floor(Math.random()*9)
        rm2++
        if(rm2>50){
            break
        }
    }
    rm = new Set(arr) // Set 객체를 이용 중복값 제거
    arr1 = Array.from(rm); //배열로 변환.

    return arr1;
}
function rmGp(){
    let rm , rm2 = 0, arr1;
    let arr =[]
    while (true){
        arr[rm2] = Math.floor(Math.random() * 3)
        rm2++
        if(rm2>10){
            break
        }
    }
    rm = new Set(arr) // Set 객체를 이용 중복값 제거
    arr1 = Array.from(rm); //배열로 변환.

    return arr1;
}
function makeJson(n,g) {
    let xhr = new XMLHttpRequest();

    let memberData = new Object();
    memberData.sidx = n;
    memberData.gidx = g;

    // let memberData = { //문자형 정의 방법
    //     "sidx" : n,  //nm
    //     "gidx" : g    //gp
    // };
    let jsonData = JSON.stringify(memberData);
    console.log(jsonData);
    let url = "http://localhost:8090/ins?jsonData="+escape(JSON.stringify(memberData));
    xhr.open('GET', url, )
    xhr.responseType = 'json';
    xhr.send();
}


    //출처: https://derveljunit.tistory.com/214 [Derveljun's Programming Log]
/*
https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/JSON

https://curryyou.tistory.com/340

https://huskdoll.tistory.com/11

https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=japkey&logNo=110152091978

https://derveljunit.tistory.com/214

https://memostack.tistory.com/245?category=755742

https://c17an.netlify.app/blog/javascript/Set-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0/article/


 */