const { divide } = require('./my-code');

describe('Test Divide Function', () => {
    test('Divides two positive numbers', () => {
        expect(divide(10, 2)).toBe(5);
    });

    test('Throws error when dividing by zero', () => {
        expect(() => divide(5, 0)).toThrow("Denominator cannot be zero.");
    });

    test('Throws TypeError for invalid types', () => {
        expect(() => divide(5, "two")).toThrow(TypeError);
    });

    test('Handles negative numbers', () => {
        expect(divide(-10, 2)).toBe(-5);
    });
});
