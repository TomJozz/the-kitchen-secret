# [The Kitchen Secret](https://hyperskill.org/learn/daily/53138)
## Hyperskill Fright Night Coding Challenge Day 4

If you've missed previous parts of the story, you can solve them here:

[Part 1](https://hyperskill.org/learn/daily/53135), [Part 2](https://hyperskill.org/learn/daily/53136), [Part 3](https://hyperskill.org/learn/daily/53137)

By the time you reached the kitchen, you'd already walked past numerous rooms that all looked the same, yet ... blah blah blah ... 

**A strange keypad on the wall with letters instead of digits. It looked like this:**

```
A B C D
E F G H
I J K L
M N O P
```

You took a folded paper taped to the corner of the keypad. It was a note with [instructions](src/main/resources/hyperskill-dataset.txt).

Apparently, whoever put this wall here wanted you to input an extremely long sequence on the keypad. 
But instead of giving you the code right away, they wrote down all movements of the finger you need to make in order to get to the proper button. 
- `UP` means you need to put your finger one key up, 
- `LEFT` one key left, 
- `RIGHT` one key right, 
- `DOWN` one key down.

Imagine the following example:

`DOWN,LEFT,RIGHT,UP,UP,RIGHT`

You always start at top left corner (on letter `A`) for each input. First, you go `DOWN` to `E`, then instruction wants you to go `LEFT`, but you can't, so you stay on `E`. Then you go `RIGHT` to `F`, `UP` to `B`, next `UP` is ignored because you can't get much higher. And finally, the last `RIGHT` puts you to `C`. So the first letter in the sequence is `C`.

After that you return back to `A` and start with the next instruction. Instructions are separated by `\n`.

"Good luck!" were the last words written in the note.
