import {Component} from 'angular2/core';
import {Injectable} from 'angular2/core';
import {Card} from './card'

@Injectable()
export class CardsService {
    getCards() {
        return Promise.resolve([
            <Card> {id: 1, answer: "Answer", question: "Ques3tion"},
            <Card> {id: 2, answer: "Ans222wer", question: "Ques33tio 23n"},
            <Card> {id: 3, answer: "Ans2wer", question: "Quest2ion"},
            <Card> {id: 4, answer: "Answ22er", question: "Ques3t3ion"},
            <Card> {id: 5, answer: "Answer", question: "Quest33ion"},
            <Card> {id: 6, answer: "Answ2er", question: "Ques3t3ion"},
            <Card> {id: 7, answer: "Answ2er", question: "Quest33ion"},
            <Card> {id: 8, answer: "Answer", question: "Quest3ion"},
            <Card> {id: 9, answer: "Answer", question: "Quest33ion"},
            <Card> {id: 10, answer: "Ans2wer", question: "Ques33tion"},
            <Card> {id: 11, answer: "Ans2wer", question: "Ques3tion"}
        ]);
    }
}

