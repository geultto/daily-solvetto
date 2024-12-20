function solution(participants, completions) {
  const hash = new Map();

  participants.forEach((participant) => {
    hash.set(participant, (hash.get(participant) || 0) + 1);
  });

  completions.forEach((completion) => {
    hash.set(completion, hash.get(completion) - 1);
  });

  for (let [key, value] of hash) {
    if (value > 0) {
      return key;
    }
  }
}
