function solution(progresses, sppeds) {
  let answer = [];

  const remainDays = progresses.map((prog, index) =>
    Math.ceil((100 - prog) / sppeds[index])
  );

  let maxDays = remainDays[0];
  answer.push(0);

  for (const rdays of remainDays) {
    if (rdays <= maxDays) {
      answer[answer.length - 1]++;
    } else {
      answer.push(1);
      maxDays = rdays;
    }
  }

  return answer;
}
