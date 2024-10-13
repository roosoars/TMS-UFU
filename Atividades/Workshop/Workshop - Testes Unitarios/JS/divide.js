function divide(numerator, denominator) {
    if (typeof numerator !== 'number' || typeof denominator !== 'number') {
        throw new TypeError("Tanto o numerador quanto o denominador devem ser números.");
    }
    if (denominator === 0) {
        throw new Error("Denominator não pode ser zero.");
    }
    return numerator / denominator;
}

module.exports = { divide };
