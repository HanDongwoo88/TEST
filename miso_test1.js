/*
Test #1
Write a command-line program that prints out the sum of two non-negative integers as input arguments. You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

const readLine = require('readline');

const commandLine = readLine.createInterface({
  input: process.stdin,
  output: process.stdout
});


let inputCount = 1;
const inputNumbers = [];
const NUMBERS = {
  "1": 1, "2": 2, "3": 3, "4": 4, "5": 5,
  "6": 6, "7": 7, "8": 8, "9": 9
};

commandLine.setPrompt('Input Number > ');
commandLine.prompt();
commandLine.on('line', function (line) {
  inputNumbers.push(line);
  if (inputCount == 2) {
    const resNum = inputNumbers.reduce((sum, n) => sum + parseInt(n), 0)
    console.log('Result > ', resNum);
    commandLine.close();
  }
  commandLine.prompt()
  inputCount++
});
commandLine.on('close', function () {
  process.exit();
});


function parseInt(numberString) {
  let result = 0;
  for (let i = 0; i < numberString.length; i++) {
    const char = numberString.charAt(i);
    result += NUMBERS[char];
    result *= 10;
  }
  result /= 10;
  return result;
}