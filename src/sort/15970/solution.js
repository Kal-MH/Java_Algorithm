const readFile = () => require("fs").readFileSync(0).toString().trim();

let N;
const a = new Array(5001).fill().map(() => []);

const getInput = () => {
  const input = readFile().split("\n");
  N = +input[0];

  for (let i = 1; i <= N; i++) {
    const [coord, color] = input[i].split(" ").map((v) => +v);

    a[color].push(coord);
  }
};

const toLeft = (color, idx) => {
  if (idx === 0) return Infinity;
  return a[color][idx] - a[color][idx - 1];
};

const toRight = (color, idx) => {
  if (idx + 1 == a[color].length) return Infinity;
  return a[color][idx + 1] - a[color][idx];
};

const pro = () => {
  for (let i = 1; i <= N; i++) a[i].sort((a, b) => a - b);

  let res = 0;
  for (let color = 1; color <= N; color++) {
    for (let i = 0; i < a[color].length; i++) {
      const leftDistance = toLeft(color, i);
      const rightDistance = toRight(color, j);

      res += Math.min(leftDistance, rightDistance);
    }
  }

  console.log(res);
};

const main = () => {
  getInput();
  pro();
};

main();
