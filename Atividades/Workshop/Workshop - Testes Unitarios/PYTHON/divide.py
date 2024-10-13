def divide(numerator: float, denominator: float) -> float:
    try:
        if denominator == 0:
            raise ValueError("Denominador não pode ser zero")
        return numerator / denominator
    except TypeError:
        raise TypeError("Tanto o numerador quanto o denominador devem ser números.")
