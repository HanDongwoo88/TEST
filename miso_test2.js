/*
Test #2
Write a command-line program that prints out the sum of two non-negative integers. Input and output integers are UTF-8 encoded Korean characters only listed as '일이삼사오육칠팔구' and '십백천만억조'. Given example input arguments as '삼조칠천팔백육십이억삼천사백삼십구' and '이십구조천이십육억칠천구백팔십육만삼천구백구십구', the output should be '삼십이조팔천팔백팔십팔억칠천구백팔십육만칠천사백삼십팔'. Google 'Korean Numbering System' if you are not familiar with.
*/

const readLine = require('readline');

const commandLine = readLine.createInterface({
  input: process.stdin,
  output: process.stdout
});

const UTF8_NUMBERS = {
  '일': 1, '이': 2, '삼': 3, '사': 4,
  '오': 5, '육': 6, '칠': 7, '팔': 8,
  '구': 9,
  '십': 10, '백': 100, '천': 1000, '만': 10000,
  '억': 100000000, '조' : 1000000000000
}

let inputCount = 1;
const inputNumbers = [];
var addResult = 0;

commandLine.setPrompt('Input Number(Korean) > ');
commandLine.prompt();
commandLine.on('line', function (line) {
    inputNumbers.push(line);
    if (inputCount == 2) {
        parseIntFromString(inputNumbers[0]);
        parseIntFromString(inputNumbers[1]);
        console.log('Result > ', parseKorean(addResult + ""))
        commandLine.close();
    }
    commandLine.prompt()
    inputCount++
});
commandLine.on('close', function () {
    process.exit();
});

function parseIntFromString(strNum){
    if(strNum.indexOf('조') >= 0) {
        addResult += parseIntFromUTF8(strNum.split('조')[0]) * UTF8_NUMBERS['조'];
        parseIntFromString(strNum.split('조')[1]);
    } else if(strNum.indexOf('억') >= 0) {
        addResult +=  parseIntFromUTF8(strNum.split('억')[0]) * UTF8_NUMBERS['억'];
        parseIntFromString(strNum.split('억')[1]);
    } else if(strNum.indexOf('만') >= 0) {
       addResult +=  parseIntFromUTF8(strNum.split('만')[0]) * UTF8_NUMBERS['만'];
       parseIntFromString(strNum.split('만')[1]);
    } else {
        addResult += parseIntFromUTF8(strNum);
    }
}

function parseIntFromUTF8(strNum) {
    let result = 0;
    let flag = 0;
    
    strNum.split("").forEach((v, i, arr) => {
    const parsedNum = UTF8_NUMBERS[v];
    const nextParsedNum = UTF8_NUMBERS[arr[i + 1]];
        
    if (nextParsedNum % 10 === 0) {
        flag = parsedNum
    }

    if (parsedNum % 10 === 0) {
        if (flag > 0) {
            result += flag * parsedNum
            flag = 0
        } else {
            result += parsedNum
        }
    } else if (nextParsedNum % 10 !== 0) {
      result += parsedNum
    }
  })
  return result;
}

function parseKorean(num) {
     num = num.replace(/,/gi, '');
     var koranArray = new Array("","일","이","삼","사","오","육","칠","팔","구","십");
     var danArray = new Array("","십","백","천","","십","백","천","","십","백","천","","십","백","천");
     var result = "";
     for(i=0; i<num.length; i++){
      str = "";
      han = koranArray[num.charAt(num.length-(i+1))];
      if(han != "") str += han+danArray[i];
      if(i == 4) str += "만";
      if(i == 8) str += "억";
      if(i == 12) str += "조";
      result = str + result;
     }

     if(num != 0) result = result;
     return result;
}
